TARGET =	Stage

# Directories
ROOT =		$(PWD)
SRCDIR = 	$(ROOT)/src
LIBDIR =	$(ROOT)/libs
CLASSDIR = 	$(ROOT)/classes
MAIN =		$(SRCDIR)/$(TARGET)
PARSER =	$(SRCDIR)/parser
INTERP =	$(SRCDIR)/interp
BIN =		$(ROOT)/bin

# Executable
EXEC = 		$(BIN)/$(TARGET)
JARFILE =	$(BIN)/$(TARGET).jar
MANIFEST=	$(BIN)/$(TARGET)_Manifest.txt

# Libraries and Classpath
LIB_ANTLR =	$(LIBDIR)/antlr-3.4-complete.jar
LIB_CLI =	$(LIBDIR)/commons-cli-1.2.jar
LIB_PROCESSING_MAC = $(LIBDIR)/Processing/core.jar:$(LIBDIR)/Processing/jogl-all.jar:$(LIBDIR)/Processing/gluegen-rt.jar:$(LIBDIR)/Processing/jogl-all-natives-macosx-universal.jar:$(LIBDIR)/Processing/gluegen-rt-natives-macosx-universal.jar
LIB_VIDEO_MAC = $(LIBDIR)/Processing/video/video.jar:$(LIBDIR)/Processing/video/gstreamer-java.jar:$(LIBDIR)/Processing/video/jna.jar
LIB_AUDIO_MAC = $(LIBDIR)/Processing/audio/jl1.0.jar:$(LIBDIR)/Processing/audio/jsminim.jar:$(LIBDIR)/Processing/audio/minim.jar:$(LIBDIR)/Processing/audio/mp3spi1.9.4.jar:$(LIBDIR)/Processing/audio/tritonus_aos.jar:$(LIBDIR)/Processing/audio/tritonus_share.jar
LIB_MIDI_MAC  = $(LIBDIR)/Processing/midi/themidibus.jar

#application.windows32=core.jar,jogl-all.jar,gluegen-rt.jar,jogl-all-natives-windows-i586.jar,gluegen-rt-natives-windows-i586.jar
#application.windows64=core.jar,jogl-all.jar,gluegen-rt.jar,jogl-all-natives-windows-amd64.jar,gluegen-rt-natives-windows-amd64.jar
#application.linux32=core.jar,jogl-all.jar,gluegen-rt.jar,jogl-all-natives-linux-i586.jar,gluegen-rt-natives-linux-i586.jar
#application.linux64=core.jar,jogl-all.jar,gluegen-rt.jar,jogl-all-natives-linux-amd64.jar,gluegen-rt-natives-linux-amd64.jar

CLASSPATH=	$(LIB_ANTLR):$(LIB_CLI):$(LIB_PROCESSING_MAC):$(LIB_VIDEO_MAC):$(LIB_AUDIO_MAC):$(LIB_MIDI_MAC)
JARPATH=	"$(LIB_ANTLR)  $(LIB_CLI)"
PROCESSING_MAC_MAIN= "$(LIBDIR)/Processing/core.jar $(LIBDIR)/Processing/jogl-all.jar  $(LIBDIR)/Processing/gluegen-rt.jar $(LIBDIR)/Processing/jogl-all-natives-macosx-universal.jar $(LIBDIR)/Processing/gluegen-rt-natives-macosx-universal.jar"
PROCESSING_MAC_VIDEO= "$(LIBDIR)/Processing/video/video.jar $(LIBDIR)/Processing/video/gstreamer-java.jar $(LIBDIR)/Processing/video/jna.jar"
PROCESSING_MAC_AUDIO="$(LIBDIR)/Processing/audio/jl1.0.jar $(LIBDIR)/Processing/audio/jsminim.jar $(LIBDIR)/Processing/audio/minim.jar $(LIBDIR)/Processing/audio/mp3spi1.9.4.jar $(LIBDIR)/Processing/audio/tritonus_aos.jar $(LIBDIR)/Processing/audio/tritonus_share.jar"
PROCESSING_MAC_MIDI = "$(LIBDIR)/Processing/midi/themidibus.jar"

# Distribution (tar) file
DATE= 		$(shell date +"%d%b%y")
DISTRIB=	$(TARGET)_$(DATE).tgz

# Classpath


# Flags
JFLAGS =	-classpath $(CLASSPATH) -d $(CLASSDIR)

# Source files
GRAMMAR = 		$(PARSER)/$(TARGET).g

MAIN_SRC =		$(MAIN)/$(TARGET).java

PARSER_SRC =	$(PARSER)/$(TARGET)Lexer.java \
				$(PARSER)/$(TARGET)Parser.java
				
#				$(INTERP)/Interp.java
INTERP_SRC =	$(INTERP)/*.java \
				$(INTERP)/GLSLTranslator/*.java \
				$(INTERP)/Semantic/*.java \
				$(INTERP)/Types/*.java \
				$(INTERP)/Player/*.java

ALL_SRC =		$(MAIN_SRC) $(PARSER_SRC) $(INTERP_SRC)
				
all: compile exec

compile:
	antlr3 -o $(PARSER) $(GRAMMAR)
	if [ ! -e $(CLASSDIR) ]; then\
	  mkdir $(CLASSDIR);\
	fi
	javac $(JFLAGS) $(ALL_SRC)

exec:
	if [ ! -e $(BIN) ]; then\
	  mkdir $(BIN);\
	fi
	echo "Main-Class: Stage.Stage" > $(MANIFEST)
	echo "Class-Path: $(JARPATH) " >> $(MANIFEST) #mind the gap.
	echo " $(PROCESSING_MAC_MAIN) " >> $(MANIFEST)
	echo " $(PROCESSING_MAC_VIDEO) " >> $(MANIFEST)
	echo " $(PROCESSING_MAC_AUDIO) " >> $(MANIFEST)
	echo " $(PROCESSING_MAC_MIDI)" >> $(MANIFEST)
	cd $(CLASSDIR); jar -cmf $(MANIFEST) $(JARFILE) *
	printf "#!/bin/sh\n\n" > $(EXEC)
	printf 'exec java -enableassertions -jar $(JARFILE) "$$@"' >> $(EXEC)
	chmod a+x $(EXEC)
	
clean:
	rm -rf $(PARSER)/*.java $(PARSER)/*.tokens 
	rm -rf $(CLASSDIR)

distrib: clean
	rm -rf $(JAVADOC)
	rm -rf $(BIN)

tar: distrib
	cd ..; tar cvzf $(DISTRIB) $(TARGET); mv $(DISTRIB) $(TARGET); cd $(TARGET) 
