filter testA(float k) {
	bool t = true;
	int p = 5;
	float n = 5.0;
	float m = n*5.0;
	vec4 hop = vec4(0.0,0.0,0.0,0.0);
	
	hop.x = hop.y;
	hop.z = 5.0;
	vec4(0.0,0.0,0.0,0.0);

	while(not t) {
		float p = hop.w;
		m = p*m;
	}
	
	if( (m != n) or (m < 5.0) ) {
		m = m*m;
	}
	return vec4(k,k,m-n,n);
}

filter v1,v2 -> mix(float m) {
	return v1[UV]*m + v1[UV]*(1.0-m);
//	return v1[UV]*vec4(m,m,m,m) + v2[UV]*(vec4(1.0,1.0,1.0,1.0)*vec4(m,m,m,m));
}

function main() {
FIRST:
	l = a.b[5].c().b[d(e[1])].p;
	xa.b[5].c().b[d(e[1])].p;
	x = a*b+e*c/d;
	a = -b;
	c = not c;
	d = mn.funcion()*5;
	d = 5*mn.funcion();
	d = 5*mn.a.funcion();
	d = 5*mn.a.b.funcion();
	e = x;
	f = x.y;
	f = x.y.w;
	f = x.y.w.z;
	
	funcion();
	
	int variable;

	video v1 = video("nomdelfitxer");
	video v2 = video("nomdelfitxer");

	image background = image("nomdelfitxer");
	
	audio music = music("elquesigui");
	
	v1.play();
	v2.play.meinventoesto();
	music.play();

LOOP:

	v1,background -> mix(0.2) -> mix1;
	v2 -> edgeDetect(0.1) -> edges;
	mix1,edges -> mix(0.5) -> pre;
	pre -> OUTPUT;

	bool beat;
	detectBeat(beat, music, treshold);
	if(beat) {
		flash() from now until now+0.5;
	}

}

function float square(float num) {
FIRST:
	return num*num;
}

function flash() {
FIRST:
	float intensity = 1.0;

LOOP:
	bypass mix1 with 1; //equiv. a fer "bypass mix1 with v1;" Elimina el filtre mix i tenim: v1 -> mix1 (mix1 := v1)
	add (pre -> flashFilter(intensity) -> pre2) after pre; //afegim el flashfilter despres de pre. Tot el que tenia "pre" com a entrada passa a tenir "pre2"
	intensity = intensity - 0.01;

	if(intensity < 0.0) {
		quit; //finalitzem abans d'hora la funcio.
	}

LAST:

}

function detectBeat(bool beat, audio music, float treshold) {
FIRST:
	int i = 0;
	float sum = 0.0;

	while(i < music.fft.size) {
		sum = sum + music.fft[i];
		i = i+1;
	}
	
	if(sum/music.fft.size > treshold) {
		beat = true;
	} else {
		beat = false;
	}
}




