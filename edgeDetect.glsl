#ifdef GL_ES
    precision mediump float;
    precision mediump int;
#endif

#define PROCESSING_COLOR_SHADER

uniform float time
uniform vec2 resolution
uniform sampler2D v;
uniform float treshold;
void main() {
    vec2 UV = gl_FragCoord.xy / resolution.xy;
    vec4 c = (9.0)*(texture2D(v, UV));
    float i = 1.0;
    float j = 1.0;
    float offsetX = (1.0)/(resolution.x);
    float offsetY = (1.0)/(resolution.y);
    while((i)<=(3.0)) {
        while((j)<=(3.0)) {
            c = (c)-(texture2D(v, vec2(((offsetX)*(i))+(UV.x), ((offsetY)*(j))+(UV.y))));
            j = (j)+(1.0);
        }
        i = (i)+(1.0);
    }
    if(((((c.x)*(c.x))+((c.y)*(c.y)))+((c.z)*(c.z)))<(treshold)) {
        glFragColor = vec4(1.0, 1.0, 1.0, 1.0)
    } else {
        glFragColor = vec4(0.0, 0.0, 0.0, 1.0)
    }
}
