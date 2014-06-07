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
uniform float x;
uniform float y;
void main() {
    vec2 UV = gl_FragCoord.xy / resolution.xy;
    vec4 pinta = (((((texture2D(v.texture , (UV)-(vec2(x,y))))+((2.0)*(texture2D(v.texture , (UV)-(vec2(0.0,y))))))+(texture2D(v.texture , (UV)-(vec2(-(x),y)))))-(texture2D(v.texture , (UV)-(vec2(x,-(y))))))-((2.0)*(texture2D(v.texture , (UV)-(vec2(0.0,-(y)))))))-(texture2D(v.texture , (UV)-(vec2(-(x),-(y)))));
    gl_FragColor = vec4(pinta.x,pinta.y,pinta.z,1.0);
}
