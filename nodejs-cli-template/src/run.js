'use strict';

const utils = require('./utils');
const deploy = require('./commands/deploy');

const {
    banner, configParser
} = utils;

const run = async (command, options) => {
    banner();
    console.log("Command: ", JSON.stringify(command));
    console.log("Options: ", JSON.stringify(options));
    try {
        if (command === 'deploy') {
            deploy(configParser())
        }
    } catch (error) {
        throw error
    }
};

module.exports = run;