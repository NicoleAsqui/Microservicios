import http from 'k6/http';
import { check, sleep } from 'k6';

export let options = {
    stages: [
        { duration: '10s', target: 10 },  // Ramp-up: 10 usuarios concurrentes en 10 segundos
        { duration: '30s', target: 10 },  // Mantener 10 usuarios por 30 segundos
        { duration: '10s', target: 0 },   // Ramp-down: Volver a 0 usuarios
    ],
};

export default function () {
    let res = http.get('http://localhost:8081/api/books');

    check(res, {
        'status es 200': (r) => r.status === 200,
        'respuesta en menos de 200ms': (r) => r.timings.duration < 200,
    });

    sleep(1); // Simula que el usuario tarda en hacer otra petición
}
