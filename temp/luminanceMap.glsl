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
uniform float factor;
void main() {
    vec2 UV = gl_FragCoord.xy / resolution.xy;
    float light = (((0.2126)*(texture2D(v.texture , UV).x))+((0.7152)*(texture2D(v.texture , UV).y)))+((0.0722)*(texture2D(v.texture , UV).z));
    if((light)>(factor)) {
        gl_FragColor = vec4(1.0,1.0,1.0,1.0);
    } else {
        gl_FragColor = vec4(0.0,0.0,0.0,1.0);
    }
}
