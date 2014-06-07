function flow(node n) {
FIRST:
	video v = video("binaryflow.mp4");
	v.play();
	v.jump(185.0);
	
	bool music = false;
LOOP:
	if(v.width > 0.0 and not music) { //Dispara la musica quan el video ja s'hagi carregat.
		moroder(n) from now until INFINITY; 
		music = true;
	}

	if(v.time() > 3.0*60.0+20.0) {
		v.jump(3.0*60.0+8.0);
	}

	v -> n;
}

function pre2out(node n) {
LOOP:
	n -> output;
}

function main() {
FIRST:
	node pre;
	flow(pre) from now until INFINITY;
	pre2out(pre) from now until INFINITY;
	quit;		
}

function moroder(node n) {
FIRST:
	audio song = audio("Racer.mp3");
	song.play();
	float treshold = 0.0;
	node white;
	node l;
	decay(treshold) from now until INFINITY;
LOOP:
	if(bombo(song) > 55.0) {
		treshold = 1.1;
		println(bombo(song));
	}
	
	if(treshold > 0.0) {
		-> pinta(1.0,1.0,1.0) -> white;
		add (white,n -> mix(treshold) -> l) after n;
	}
}

function void decay(float n) {
LOOP:
	n = n-0.22;
}

function float bombo(audio a) {
FIRST:
	float[4] fft = a.FFT();
	int i=0;
	float v = 0.0;
	while(i < 10) {
		v = v + fft[i];
		i = i+1;
	}
	v = v/float(10);
	return v;
}


filter v1,v2 -> mix(float m) {
	float n = 1.0-m;
	vec2 k = vec2(0.5,0.5);
	return v1[UV]*m+v2[UV]*n;
}

filter pinta(float r, float g, float b) {
	return vec4(r,g,b,1.0);
}

