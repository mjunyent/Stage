function main() {
FIRST:
	audioInput input;
	input.init();
	input.monitoring(true);

LOOP:
	int i = 0;
	float f = 0.0;

	while(i < input.size) {
		f = f + input.left(i)*input.left(i);
		i = i+1;
	}
	f = f / float(input.size);
	
	println("Audio: " + f);
}
