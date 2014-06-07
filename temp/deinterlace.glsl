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
uniform SampleTexture red;
uniform SampleTexture cian;
uniform float x;
uniform float y;
void main() {
    vec2 UV = gl_FragCoord.xy / resolution.xy;
    vec2 rp = vec2((UV.x)-(x),(UV.y)-(y));
    vec2 cp = vec2((UV.x)+(x),(UV.y)+(y));
    gl_FragColor = (texture2D(red.texture , rp))+(texture2D(cian.texture , cp));
}
