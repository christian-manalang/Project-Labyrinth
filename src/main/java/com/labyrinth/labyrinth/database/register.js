 import { initializeApp } from "https://www.gstatic.com/firebasejs/12.8.0/firebase-app.js";
  import { getAnalytics } from "https://www.gstatic.com/firebasejs/12.8.0/firebase-analytics.js";

  const firebaseConfig = {
    apiKey: "AIzaSyCuSWXowGdL1xPGb6qMihldP7joUZy5aCc",
    authDomain: "project-labyrinth-defe7.firebaseapp.com",
    projectId: "project-labyrinth-defe7",
    storageBucket: "project-labyrinth-defe7.firebasestorage.app",
    messagingSenderId: "17298788322",
    appId: "1:17298788322:web:33e23e17c03888a118f3bb",
    measurementId: "G-0XZ07H9EQM"
  };

  const app = initializeApp(firebaseConfig);
  const analytics = getAnalytics(app);