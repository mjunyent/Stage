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
    vec4 color = (texture2D(v.texture , UV))*(0.2270270270);
    float fx = (4.0)/(640.0);
    color = (color)+((texture2D(v.texture , (UV)+(vec2((1.0)*(fx),0.0))))*(0.1945945946));
    color = (color)+((texture2D(v.texture , (UV)+(vec2((2.0)*(fx),0.0))))*(0.1216216216));
    color = (color)+((texture2D(v.texture , (UV)+(vec2((3.0)*(fx),0.0))))*(0.0540540541));
    color = (color)+((texture2D(v.texture , (UV)+(vec2((4.0)*(fx),0.0))))*(0.0162162162));
    color = (color)+((texture2D(v.texture , (UV)-(vec2((1.0)*(fx),0.0))))*(0.1945945946));
    color = (color)+((texture2D(v.texture , (UV)-(vec2((2.0)*(fx),0.0))))*(0.1216216216));
    color = (color)+((texture2D(v.texture , (UV)-(vec2((3.0)*(fx),0.0))))*(0.0540540541));
    color = (color)+((texture2D(v.texture , (UV)-(vec2((4.0)*(fx),0.0))))*(0.0162162162));
    gl_FragColor = vec4(color.x,color.y,color.z,1.0);
}
