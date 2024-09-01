#import "CDVWindowVisibility.h"
#import <AVFoundation/AVFoundation.h>

@implementation CDVWindowVisibility

- (void)enable:(CDVInvokedUrlCommand*)command
{
    NSError* error = nil;
    
    AVAudioSession* session = [AVAudioSession sharedInstance];
    [session setCategory:AVAudioSessionCategoryPlayback error:&error];
    [session setActive:YES error:&error];
    
    [[UIApplication sharedApplication] beginReceivingRemoteControlEvents];
    
    if (error) {
        CDVPluginResult* pluginResult = [CDVPluginResult resultWithStatus:CDVCommandStatus_ERROR 
                                                          messageAsString:[error localizedDescription]];
        [self.commandDelegate sendPluginResult:pluginResult callbackId:command.callbackId];
    } else {
        CDVPluginResult* pluginResult = [CDVPluginResult resultWithStatus:CDVCommandStatus_OK];
        [self.commandDelegate sendPluginResult:pluginResult callbackId:command.callbackId];
    }
}

@end