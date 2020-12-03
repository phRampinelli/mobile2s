import React from 'react'
import { Alert } from 'react-native';
import {Container, Input} from './styles'

const InitialPage = () => {
    return(
        <Container>
        {/* <StatusBar hidden /> */}
        {/* <Logo source={require('../../images/airbnb_logo.png')} resizeMode="contain" /> */}
        <Input
          placeholder="Endereço de e-mail"
          value={this.state.email}
          onChangeText={this.handleEmailChange}
          autoCapitalize="none"
          autoCorrect={false}
        />
        <Input
          placeholder="Senha"
          value={this.state.password}
          onChangeText={this.handlePasswordChange}
          autoCapitalize="none"
          autoCorrect={false}
          secureTextEntry
        />
        {/* {this.state.error.length !== 0 && <ErrorMessage>{this.state.error}</ErrorMessage>}
        <Button onPress={this.handleSignInPress}>
          <ButtonText>Entrar</ButtonText>
        </Button>
        <SignUpLink onPress={this.handleCreateAccountPress}>
          <SignUpLinkText>Criar conta grátis</SignUpLinkText>
        </SignUpLink> */}
      </Container>
    )
}

export default InitialPage;