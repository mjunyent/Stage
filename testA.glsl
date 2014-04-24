#ifdef GL_ES
precision mediump float;
precision mediump int;
#endif

#define PROCESSING_COLOR_SHADER

uniform float time
uniform vec2 resolution
uniform float k;
void main() {
vec2 UV = gl_FragCoord.xy / resolution.xy;
    bool t = true;
    int p = 5;
    float n = 5.0;
    float m = (n)*(5.0);
    vec4 hop = vec4(0.0, 0.0, 0.0, 0.0);
    hop.x = hop.y;
    hop.z = 5.0;
    vec4(0.0, 0.0, 0.0, 0.0)
    while(!(t)) {
        float p = hop.w;
        m = (p)*(m);
    }
    if(((m)!=(n))||((m)<(5.0))) {
        m = (m)*(m);
    }
    glFragColor = vec4(k, k, (m)-(n), n)
}
