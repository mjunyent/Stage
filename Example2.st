/* Aquest programa renderitza un video fent 2 segons en cada component (RGB).
 * La funcio draw es crida a ella mateixa quan esta a punt d'acabar canviant els seus parametres.
 */

//Dibuixa nomes la component vermella
filter v1 -> red() {
	OUTPUT = new vec4(v1[UV].r, 0.0, 0.0, v1[UV].a);
}

//Dibuixa nomes la component verda
filter v1 -> green() {
	OUTPUT = new vec4(0.0, v1[UV].g, 0.0, v1[UV].a);
}

//Dibuixa nomes la component blava
filter v1 -> blue() {
	OUTPUT = new vec4(0.0, 0.0, v1[UV].b, v1[UV].a);
}

function main() {
FIRST:
	video v1 = new video("fitxer");
	
	v1.loop(); //reproduim el video en loop

	v1 -> interm; //creem un node intermedi. Els nodes tenen visibilitat global, pero els videos no.

	draw(0) from now until now+2.0; //cridem draw des de ara fins d'aqui a dos segons.
LOOP:

LAST:

}


function draw(int color) {
FIRST:
	int myColor = color; //d'aquesta manera no ens afecten les posibles modificacions a la variable color.
LOOP:
	if(myColor == 0) {
		interm -> red() -> OUTPUT;
	}
	if(myColor == 1) {
		interm -> green() -> OUTPUT;
	}
	if(myColor == 2) {
		interm -> blue() -> OUTPUT;
	}
LAST:
	draw((color+1)%3) from now until now+2.0;
}