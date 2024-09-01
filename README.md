# Cordova Window Visibility Plugin

This Cordova plugin allows your app to keep the window visible even when it's in the background. This is particularly useful for apps that need to continue running processes or playing media when the app is not in the foreground.

## Installation

```
cordova plugin add cordova-window-visibility
```

## Usage

To enable the window visibility feature:

```javascript
document.addEventListener('deviceready', onDeviceReady, false);

function onDeviceReady() {
    cordova.plugins.windowVisibility.enable(
        function() { console.log('Window visibility enabled successfully'); },
        function(error) { console.error('Error enabling window visibility:', error); }
    );
}
```

## Supported Platforms

- Android
- iOS

## License

MIT

## Contributing

Contributions are welcome! Please feel free to submit a Pull Request.