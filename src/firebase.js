import * as firebase from 'firebase/app'
import 'firebase/firestore'
import 'firebase/storage'
import 'firebase/auth'

import store from "./store";

// Your web app's Firebase configuration
// For Firebase JS SDK v7.20.0 and later, measurementId is optional
let firebaseConfig = {
    apiKey: "AIzaSyAGfz8oMqFZ6xPtfLaZ8-lu44Kgd6JMGzA",
    authDomain: "helloanwar-a7c18.firebaseapp.com",
    databaseURL: "https://helloanwar-a7c18.firebaseio.com",
    projectId: "helloanwar-a7c18",
    storageBucket: "helloanwar-a7c18.appspot.com",
    messagingSenderId: "689196737657",
    appId: "1:689196737657:web:96ed77ed21c4916e3ca0a8",
    measurementId: "G-X5HKYDZK05"
};
// Initialize Firebase
firebase.initializeApp(firebaseConfig);

firebase.auth().onAuthStateChanged(user => {
    store.dispatch("fetchUser", user);
});

firebase.getCurrentUser = () => {
    return new Promise((resolve, reject) => {
        const unsubscribe = firebase.auth().onAuthStateChanged(user => {
            unsubscribe();
            resolve(user);
        }, reject);
    })
};

// utils
const db = firebase.firestore()
const storage = firebase.storage()
const projectCollection = db.collection('projects')
const messageCollection = db.collection('messages')
const projectsStorage = storage.ref('projects/');

export {
    db,
    projectCollection,
    messageCollection,
    storage,
    projectsStorage,
    firebase
}

