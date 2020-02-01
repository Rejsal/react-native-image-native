import React from 'react';
import { requireNativeComponent, Platform, Image } from 'react-native';

const ImageNativeComponent = Platform.select({
  // sorry iOS :(
  ios: Image, 
  
  // name from overriden `getName` function
  android: requireNativeComponent('GlideImageViewManager'),
});


export default class ImageNative extends React.Component {
    render(){
        return (
            <ImageNativeComponent style={this.props.styles} {...this.props}/>
        )
    }
}
