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
uniform SampleTexture map;
uniform SampleTexture image;
void main() {
    vec2 UV = gl_FragCoord.xy / resolution.xy;
    float l = texture2D(map.texture , UV).x;
    if((l)>(0.8)) {
        gl_FragColor = texture2D(image.texture , UV);
    } else {
        gl_FragColor = vec4(0.0,0.0,0.0,1.0);
    }
}
