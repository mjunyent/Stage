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
	float n = 1.0-m;
	vec2 k = vec2(0.5,0.5);
	return v1[UV]*m+v2[UV]*n;
//	return v1[UV]*vec4(m,m,m,m) + v2[UV]*(vec4(1.0,1.0,1.0,1.0)*vec4(m,m,m,m));
}

filter pinta(float r, float g, float b) {
	return vec4(r,g,time/10.0,1.0);
}

function main() {
FIRST:
	audio song = audio("Talos' Corpse.mp3");
	song.play();
	
	int variable = 0;
	float p = 0.0;
//	vec4 n = vec4(0.0,0.0,0.0,0.0);
	println(3);
	println(p);
	vec4 m;
	m.x = 6.0;
	println(m.x);
	m.x = m.x*2.0;
	println(m.x);
	
//	printFC(p) from 10.0 until 10000.0;
//	printFC(p-10.0) from 14.0 until 18.0;
	makeItCry() from 2.0 until 100.0;

	node A;
	node B;
	node C;
	node D = node(10, 10);
	
	vec4 alehop;
	alehop = vec4(1.9,2.9,5.3,8.7);
	println("(" + alehop.x + "," + alehop.y + "," + alehop.z + "," + alehop.w + ")");
	
	//video v = video("transit.mov");
	//v.loop();
	//v.speed(2.0);
	
	video flow = video("binaryflow.mp4");
	flow.play();
	flow.jump(185.0);
	
	//camera cam = camera(0);
	//cam.start();
//	drawRed(A) from 10.0 until 12.0;
	/*
	video v1 = video("nomdelfitxer");
	video v2 = video("nomdelfitxer");

	image background = image("nomdelfitxer");
	
	audio music = music("elquesigui");
	
	v1.play();
	v2.play.meinventoesto();
	music.play();*/
	int k = 0;
	
//	song.setLoopPoints(9.2, 9.4);
//	song.loop();

LOOP:

	println("VAMOS POR: " + now);
		
	println("    TE MIDE: " + song.FFT().size);
int m =0;
float[4] ne = song.FFT();
float val = 0.0;
while(m < ne.size) {
	val = val + ne[m];
	m = m+1;
}
println("VALES: " + val);

-> pinta(1.0,1.0,1.0) -> A;
//flow -> D;
A,flow -> mix(val/1200.0) -> D;
	D -> output;
//flow -> output;

	//println("DT: " + dt);
/*	-> pinta(1.0,0.0,0.0) -> A;
	-> pinta(0.0,0.0,1.0) -> B;
	
	
	A,B -> mix(0.5) -> output;
	
	C,C -> mix(0.5) -> A;

	add (A,B -> mix(0.5) -> C) after A;*/

//	-> pinta(1.0,0.0,0.0) -> A;
	//cam -> A;
	
/*	-> pinta(0.0, 0.0, 1.0) -> B;
	v,cam -> mix(0.5) -> A;
	A,B -> mix(0.5) -> output;*/

	//-> pinta(0.0,0.0,1.0) -> A;
	//-> pinta(0.0,1.0,0.0) -> B;
	//v,A -> mix(0.2) -> C;
	//cam,B -> mix(0.2) -> D;
	//C,D -> mix(0.5) -> output;
	
	if(flow.time() > 199.0) {
		flow.jump(186.0);
	}
//	cam->output;
		
//	A -> output;
//println("Now: " + now + " Time: " + time + " dt: " + dt);
/*
	-> pinta(1.0,0.0,0.0) -> A;
	-> pinta(0.0,0.0,1.0) -> B;
	node C;
	node D;
	B -> C;
	C -> D;
//	C = B; //detect and delete unused nodes -> if it's out of scope.....
	A,D -> mix(0.5) -> output;
	*/
	
	
/*	println(true);
	println(p);
	float m = 4.0;
	
	float k = square(m);
	println(k);
	println(m);
	
	println(cube(m));
	println(m);*/

	p = p+1.0;
//	printFC(p);
	
LAST:
	println(9.0);
}

function void makeItCry() {
LOOP:
	if(now > 5.0) {
		//cube(5.0);
		//quit;
	}
}

function void drawRed(node X) {
FIRST:
	println("RED");
LOOP:
	-> pinta(1.0,0.0,0.0) -> X;
LAST:
	drawBlue(X) from now until now+2.0;
}

function void drawBlue(node X) {
FIRST:
	println("BLUE");
LOOP:
	-> pinta(0.0,0.0,1.0) -> X;
LAST:
	drawRed(X) from now until now+2.0;
}

function float cube(float num) {
FIRST:
	num = num*square(num);	
LOOP:
	println(false);
LAST:
	return num;
}

function float square(float num) {
FIRST:
num = num*num;
int[5] a;
a[7] = 4;
LOOP:
//return a*a-1.0;
LAST:
return num;
//	return num*num;
}

function float printFC(float num) {
FIRST:
	println("FIRST!");
LOOP:
	//println("Frame number: " + num);
LAST:
	println("LAST!");
}




