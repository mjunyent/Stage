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
    float fy = (4.0)/(480.0);
    color = (color)+((texture2D(v.texture , (UV)+(vec2(0.0,(1.0)*(fy)))))*(0.1945945946));
    color = (color)+((texture2D(v.texture , (UV)+(vec2(0.0,(2.0)*(fy)))))*(0.1216216216));
    color = (color)+((texture2D(v.texture , (UV)+(vec2(0.0,(3.0)*(fy)))))*(0.0540540541));
    color = (color)+((texture2D(v.texture , (UV)+(vec2(0.0,(4.0)*(fy)))))*(0.0162162162));
    color = (color)+((texture2D(v.texture , (UV)-(vec2(0.0,(1.0)*(fy)))))*(0.1945945946));
    color = (color)+((texture2D(v.texture , (UV)-(vec2(0.0,(2.0)*(fy)))))*(0.1216216216));
    color = (color)+((texture2D(v.texture , (UV)-(vec2(0.0,(3.0)*(fy)))))*(0.0540540541));
    color = (color)+((texture2D(v.texture , (UV)-(vec2(0.0,(4.0)*(fy)))))*(0.0162162162));
    gl_FragColor = vec4(color.x,color.y,color.z,1.0);
}
