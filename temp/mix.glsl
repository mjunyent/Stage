#ifdef GL_ES
    precision mediump float;
    precision mediump int;
#endif

#define PROCESSING_COLOR_SHADER

uniform float time;
uniform vec2 resolution;
uniform sampler2D v1;
uniform sampler2D v2;
uniform float m;

void main() {
    vec2 UV = gl_FragCoord.xy / resolution.xy;
    float n = (1.0)-(m);
    vec2 k = vec2(0.5, 0.5);
    gl_FragColor = ((texture2D(v1, UV))*(m))+((texture2D(v2, UV))*(n));
}
