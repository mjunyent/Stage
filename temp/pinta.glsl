#ifdef GL_ES
    precision mediump float;
    precision mediump int;
#endif

#define PROCESSING_COLOR_SHADER

struct SampleTexture {
    sampler2D texture;
    vec2 resolution;
};

uniform float time;
uniform vec2 resolution;
uniform float r;
uniform float g;
uniform float b;
void main() {
    vec2 UV = gl_FragCoord.xy / resolution.xy;
    gl_FragColor = vec4(r,g,b,1.0);
}
