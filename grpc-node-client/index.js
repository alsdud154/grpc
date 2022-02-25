const path = require('path');
const PROTO_PATH = path.resolve(__dirname, 'proto/hello_service.proto');

const GRPCClient = require('node-grpc-client');

const myClient = new GRPCClient(PROTO_PATH, 'hello', 'HelloService', 'localhost:8080');

const dataToSend = {
    first_name: 'Velnova',
    last_name: 'Jung'
};

myClient.runService('HelloWorld', dataToSend, (err, res) => {
    console.log('response: ', res);
}, {});