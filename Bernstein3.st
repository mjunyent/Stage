filter v -> getCian() {
	return vec4(0.0, v[UV].y, v[UV].z, v[UV].w);
}

filter v -> getRed() {
	return vec4(v[UV].x, 0.0, 0.0, v[UV].w);
}

filter red, cian -> deinterlace(float x, float y) {
	vec2 rp = vec2(UV.x-x, UV.y-y);
	vec2 cp = vec2(UV.x+x, UV.y+y);
	return red[rp]+cian[cp];
}

function main() {
FIRST:
	video v = video("beethoven.mp4");
	audio a = audio("Kick.mp3");

	float x = 0.0;
	float y = 0.0;
	decay(x,0.0025) from now until INFINITY;
	decay(y,0.0025) from now until INFINITY;
	
	a.loop();
	v.play();

	node pre;
	node cian;
	node red;

LOOP:
	if(v.time() > 1.0) {
		v.jump(0.8);
		a.stop();
		a.play();
		x = 0.01;
		y = 0.01;
	}

	v -> pre;
	pre -> getCian() -> cian;
	pre -> getRed() -> red;
	red,cian -> deinterlace(x,y) -> output;
}

function decay(float a, float rate) {
LOOP:
	a = a - rate;
	if(a < 0.0) {
		a = 0.0;
	}
}