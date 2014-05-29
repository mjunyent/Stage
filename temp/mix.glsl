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
uniform SampleTexture v1;
uniform SampleTexture v2;
uniform float m;
void main() {
    vec2 UV = gl_FragCoord.xy / resolution.xy;
    float n = (1.0)-(m);
    vec2 k = vec2(0.5,0.5);
    gl_FragColor = ((texture2D(v1.texture , UV))*(m))+((texture2D(v2.texture , UV))*(n));
}
