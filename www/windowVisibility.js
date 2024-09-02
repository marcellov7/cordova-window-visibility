var exec = require('cordova/exec');

var WindowVisibility = {
    enable: function(success, error) {
        exec(success, error, "WindowVisibility", "enable", []);
    },
    setDelay: function(delay, success, error) {
        exec(success, error, "WindowVisibility", "setDelay", [delay]);
    }
};

module.exports = WindowVisibility;