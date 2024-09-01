# Cordova Window Visibility Plugin

This Cordova plugin keeps the window visible even when the app is in the background. This is particularly useful for apps that need to continue running processes or playing media when the app is not in the foreground.

## Installation

```
cordova plugin add https://github.com/your-username/cordova-plugin-window-visibility.git
```

Or if you've published it to npm:

```
cordova plugin add cordova-plugin-window-visibility
```

## Usage

The plugin is automatically initialized and active once installed. However, if you want to manually enable it or receive a confirmation, you can use the following method:

```javascript
cordova.plugins.windowVisibility.enable(
    function(success) { console.log('Window visibility enabled:', success); },
    function(error) { console.error('Error enabling window visibility:', error); }
);
```

## Supported Platforms

- Android

## How it works

On Android, the plugin overrides the `onStop` method of the Cordova activity. When the app goes to the background, it forces the WebView to remain "visible" after a short delay, preventing the system from pausing the WebView's processes.

## License

MIT

## Contributing

Contributions are welcome! Please feel free to submit a Pull Request.