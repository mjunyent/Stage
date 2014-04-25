#ifdef GL_ES
    precision mediump float;
    precision mediump int;
#endif

#define PROCESSING_COLOR_SHADER

uniform float time
uniform vec2 resolution
uniform sampler2D v1;
uniform float intensity;
void main() {
    vec2 UV = gl_FragCoord.xy / resolution.xy;
    glFragColor = (texture2D(v1, UV))+(vec4(intensity, intensity, intensity, 0.0))
}
