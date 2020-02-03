import React from 'react';
import { requireNativeComponent, Platform, Image,View,Text } from 'react-native';

const ImageNativeComponent = Platform.select({
  ios: Image, 
  
  android: requireNativeComponent('GlideImageViewManager'),
});


export default class ImageNative extends React.Component {
    render(){
        if(this.props.source && this.props.source.trim() != '')
            return (
                <ImageNativeComponent style={this.props.styles} {...this.props}/>
            )
        else {
            if(this.props.placeholder){
                return (<Image style={this.props.styles} source={this.props.placeholder}/>)
            }else if(this.props.error){
                return (<Image style={this.props.styles} source={this.props.error}/>)
            }else {
                return (
                <View style={[this.props.styles,{backgroundColor:this.props.errorColor?this.props.errorColor:'rgba(0,0,0,0.6)'}]}/>
                )
            }
        }
    }
}
