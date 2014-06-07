function main() {
FIRST:
	node pre;
	video v = video("beethoven.mp4");
	audio a = audio("Kick.mp3");
	a.loop();
	v.play();

LOOP:
	if(v.time() > 1.0) {
		v.jump(0.8);
		a.stop();
		a.play();
	}

	v -> output;
}
