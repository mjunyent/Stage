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
	return v1[k]*m+v2[k]*n;
//	return v1[UV]*vec4(m,m,m,m) + v2[UV]*(vec4(1.0,1.0,1.0,1.0)*vec4(m,m,m,m));
}

filter pinta(float r, float g, float b) {
	return vec4(r,g,b,1.0);
}

function main() {
FIRST:
	int[5] cosa;
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
	
	printFC(p) from 10.0 until 10000.0;
	printFC(p-10.0) from 14.0 until 18.0;

	node A;
	node B;
	/*
	video v1 = video("nomdelfitxer");
	video v2 = video("nomdelfitxer");

	image background = image("nomdelfitxer");
	
	audio music = music("elquesigui");
	
	v1.play();
	v2.play.meinventoesto();
	music.play();*/

LOOP:
//println("Now: " + now + " Time: " + time + " dt: " + dt);
	-> pinta(1.0,0.0,0.0) -> A;
	-> pinta(0.0,0.0,1.0) -> B;
	node C;
	node D;
	B -> C;
	C -> D;
//	C = B; //detect and delete unused nodes -> if it's out of scope.....
	A,D -> mix(0.5) -> output;

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




