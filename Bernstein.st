function main() {
FIRST:
	node pre;
	video v = video("beethoven.mp4");
	v.play();

LOOP:
	if(v.time() > 1.0) {
		v.jump(0.8);
	}

	v -> output;
}
