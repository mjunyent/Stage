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
	
	A -> B;
	/*
	video v1 = video("nomdelfitxer");
	video v2 = video("nomdelfitxer");

	image background = image("nomdelfitxer");
	
	audio music = music("elquesigui");
	
	v1.play();
	v2.play.meinventoesto();
	music.play();*/

LOOP:
println("Now: " + now + " Time: " + time + " dt: " + dt);
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
	println("Frame number: " + num);
LAST:
	println("LAST!");
}




