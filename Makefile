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
CLASSPATH=	$(LIB_ANTLR):$(LIB_CLI)
JARPATH=	"$(LIB_ANTLR) $(LIB_CLI)"


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
INTERP_SRC =	$(INTERP)/Stack.java \
				$(INTERP)/Data.java \
				$(INTERP)/$(TARGET)Tree.java \
				$(INTERP)/StageTreeAdaptor.java \
				$(INTERP)/Types/TypeInterface.java \
				$(INTERP)/Types/Types.java \
				$(INTERP)/Types/IntType.java \
				$(INTERP)/Types/BoolType.java \
				$(INTERP)/Types/FloatType.java \
				$(INTERP)/Types/Vec4Type.java \
				$(INTERP)/Types/Vec2Type.java \
				$(INTERP)/Types/ArrayType.java \
				$(INTERP)/Semantic/FilterGlobalVars.java \
				$(INTERP)/Semantic/FilterGlobalFuncs.java \
				$(INTERP)/Semantic/FilterSymbolTable.java \
				$(INTERP)/Semantic/Semantics.java
				

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
	echo "Class-Path: $(JARPATH)" >> $(MANIFEST)
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
