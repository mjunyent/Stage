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
	int variable = 0;
	float p;
	vec4 n = vec4(0.0,0.0,0.0,0.0);
	/*
	video v1 = video("nomdelfitxer");
	video v2 = video("nomdelfitxer");

	image background = image("nomdelfitxer");
	
	audio music = music("elquesigui");
	
	v1.play();
	v2.play.meinventoesto();
	music.play();*/

LOOP:
	variable = variable+1;
	p = square(p);
	n.z = p;
}

function float square(float num) {
FIRST:
	return num*num;
}




