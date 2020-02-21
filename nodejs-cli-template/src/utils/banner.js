'use strict';

const chalk = require("chalk");
const figlet = require("figlet");

const banner = () => {
    try {
        console.log(
            chalk.green(
                figlet.textSync("OMS CLI", {
                    font: "Standard",
                    horizontalLayout: "full",
                    verticalLayout: "default"
                })
            )
        );
    } catch (error) {
        throw error
    }
};

module.exports = banner;