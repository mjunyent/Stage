#ifdef GL_ES
    precision mediump float;
    precision mediump int;
#endif

#define PROCESSING_COLOR_SHADER

uniform float time;
uniform vec2 resolution;
uniform float r;
uniform float g;
uniform float b;
void main() {
    vec2 UV = gl_FragCoord.xy / resolution.xy;
    gl_FragColor = vec4(r, g, (time)/(10.0), 1.0);
}
