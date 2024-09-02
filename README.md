# Cordova Window Visibility Plugin

This Cordova plugin keeps the window visible even when the app is in the background. This is particularly useful for apps that need to continue running processes or playing media when the app is not in the foreground.

## Installation

```
cordova plugin add https://github.com/marcellov7/cordova-window-visibility.git
```

Or if you've published it to npm:

```
cordova plugin add cordova-plugin-window-visibility
```

You can also specify a custom visibility delay during installation:

```
cordova plugin add cordova-window-visibility --variable VISIBILITY_DELAY=2000
```

## Usage

The plugin is automatically initialized and active once installed. However, you can use the following methods:

### Enable Window Visibility

```javascript
cordova.plugins.windowVisibility.enable(
    function(success) { console.log('Window visibility enabled:', success); },
    function(error) { console.error('Error enabling window visibility:', error); }
);
```

### Set Visibility Delay

You can change the visibility delay at runtime:

```javascript
cordova.plugins.windowVisibility.setDelay(3000,
    function(success) { console.log('Delay set:', success); },
    function(error) { console.error('Error setting delay:', error); }
);
```

## Configuration

- `VISIBILITY_DELAY`: The delay (in milliseconds) before the window is made visible after the app goes to the background. Default is 1000ms.

## Supported Platforms

- Android

## How it works

On Android, the plugin overrides the `onStop` method of the Cordova activity. When the app goes to the background, it forces the WebView to remain "visible" after a short delay, preventing the system from pausing the WebView's processes.

## License

Apache 2.0

## Contributing

Contributions are welcome! Please feel free to submit a Pull Request.