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
uniform SampleTexture v;
void main() {
    vec2 UV = gl_FragCoord.xy / resolution.xy;
    gl_FragColor = vec4(texture2D(v.texture , UV).x,0.0,0.0,texture2D(v.texture , UV).w);
}
