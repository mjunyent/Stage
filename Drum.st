function main() {
FIRST:
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
	copy -> luminanceMap(0.4) -> map;
//	copy -> luminanceMap(treshold) -> map;
	map,copy -> getLightMap() -> blurH;
	blurH -> blurH() -> blurV;
	blurV -> blurV() -> blurF;
	blurF,copy -> mix2() -> output;
}


