var exec = require('cordova/exec');

var WindowVisibility = {
    enable: function(success, error) {
        exec(success, error, "WindowVisibility", "enable", []);
    }
};

module.exports = WindowVisibility;