var admin = require('firebase-admin')
var serviceAccount = require('./server_key.json')

admin.initializeApp({
    credential: admin.credential.cert(serviceAccount)
})

var token = "토큰값"
var fcm_message = {
    notification: {
        title: 'noti title',
        body: 'noti body..'
    },
    data: {
        title: 'data title',
        value: '20'
    },
    toekn: token
}

admin.messaging().send(fcm_message)
    .then(function(response)){
        console.log('send ok...')
    })
    .catch(function(error){
        console.log('send error...')
    })
