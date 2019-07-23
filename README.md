# Stage
Project of the Compilers course at FIB/UPC.

Stage is a language aimed to program visuals that interact with audio or other inputs.

You can see an example here:
```
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
}```

This example loads a video, loops a part of it and renders it to screen.
