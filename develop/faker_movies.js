const mysql = require('mysql2');
const {faker} = require('@faker-js/faker');
const { v4: uuidv4 } = require('uuid');

// MySQL connection configuration
const connection = mysql.createConnection({
    host: 'localhost',
    user: 'admin',   // replace with your MySQL username
    password: 'admin', // replace with your MySQL password
    database: 'jpa'  // replace with your MySQL database name
});

// Function to insert generated movie data into the MySQL database
const insertMovie = (id, createdDate, genre, title, year) => {
    const sql = `
        INSERT INTO movies (id, created_date, genre, title, year)
        VALUES (?, ?, ?, ?, ?)
    `;
    connection.query(sql, [id, createdDate, genre, title, year], (err, results) => {
        if (err) throw err;
        console.log(`Movie inserted with ID: ${id}`);
    });
};

// Function to generate random movie data using faker
const generateMovieData = () => {
    const id = uuidv4();
    const createdDate = faker.date.past(5).toISOString().slice(0, 19).replace('T', ' ');
    const genre = faker.music.genre();
    const title = faker.commerce.productName();  // Using productName for random titles
    const year = faker.date.past(20).getFullYear().toString();

    insertMovie(id, createdDate, genre, title, year);
};

// Generate and insert 10 random movies
for (let i = 0; i < 10000; i++) {
    generateMovieData();
}

// Close the connection after inserting the data
connection.end();
