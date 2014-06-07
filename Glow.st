filter v1,v2 -> mix2() {
	return v1[UV] + v2[UV] - v1[UV]*v2[UV];
//	(src + dst) - (src * dst)
}

filter v -> luminanceMap(float factor) {
	float light = (0.2126*v[UV].x + 0.7152*v[UV].y + 0.0722*v[UV].z);
	if(light > factor) {
		return vec4(1.0,1.0,1.0,1.0);
	}
	else {
		return vec4(0.0,0.0,0.0,1.0);
	}
}

filter map,image -> getLightMap() {
	float l = map[UV].x;
	if(l > 0.8) {
		return image[UV];
	} else {
		return vec4(0.0,0.0,0.0,1.0);
	}
}

filter v -> blurH() {
	vec4 color = v[UV]*0.2270270270;
	float fx = 4.0/640.0;
	
	color = color + v[UV + vec2(1.0*fx, 0.0)] * 0.1945945946;
	color = color + v[UV + vec2(2.0*fx, 0.0)] * 0.1216216216;
	color = color + v[UV + vec2(3.0*fx, 0.0)] * 0.0540540541;
	color = color + v[UV + vec2(4.0*fx, 0.0)] * 0.0162162162;
	
	color = color + v[UV - vec2(1.0*fx, 0.0)] * 0.1945945946;
	color = color + v[UV - vec2(2.0*fx, 0.0)] * 0.1216216216;
	color = color + v[UV - vec2(3.0*fx, 0.0)] * 0.0540540541;
	color = color + v[UV - vec2(4.0*fx, 0.0)] * 0.0162162162;

	return vec4(color.x, color.y, color.z, 1.0);
}

filter v -> blurV() {
	vec4 color = v[UV]*0.2270270270;
	float fy = 4.0/480.0;
	
	color = color + v[UV + vec2(0.0, 1.0*fy)] * 0.1945945946;
	color = color + v[UV + vec2(0.0, 2.0*fy)] * 0.1216216216;
	color = color + v[UV + vec2(0.0, 3.0*fy)] * 0.0540540541;
	color = color + v[UV + vec2(0.0, 4.0*fy)] * 0.0162162162;
	
	color = color + v[UV - vec2(0.0, 1.0*fy)] * 0.1945945946;
	color = color + v[UV - vec2(0.0, 2.0*fy)] * 0.1216216216;
	color = color + v[UV - vec2(0.0, 3.0*fy)] * 0.0540540541;
	color = color + v[UV - vec2(0.0, 4.0*fy)] * 0.0162162162;

	return vec4(color.x, color.y, color.z, 1.0);
}

function main() {
FIRST:
	camera cam = camera(0);
	cam.start();
	node map;
	node temp;
	node copy;
	node blurH = node(640/4, 480/4);
	node blurV = node(640/4, 480/4);
	node blurF;
	
	midiBus bus = midiBus("busA", "SLIDER/KNOB", "");
	float treshold = 1.0;

LOOP:

	midiMsg[1] messages = bus.messages();
	int m = 0;
	while(m<messages.size) {
		treshold = messages[m].value;
		m = m+1;
	}
	println(treshold);
	
	cam -> copy;
	blurH -> blurH() -> blurV;
	blurV -> blurV() -> blurF;
	blurF,copy -> mix2() -> output;

//	copy -> luminanceMap(0.4) -> map;
	copy -> luminanceMap(treshold) -> map;
	map,copy -> getLightMap() -> blurH;
}


