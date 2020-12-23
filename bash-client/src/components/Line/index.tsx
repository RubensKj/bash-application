import React from 'react';

// Components
import InfoInput from '../InfoInput';

// Container
import { Container, Text } from './styles';

export interface LineInterface {
  id: String;
  isCommand: Boolean;
  text: String;
  homeDirectory: String;
}

const Line: React.FC<LineInterface> = ({ isCommand, homeDirectory, text }) => {
  return (
    <Container>
      {isCommand && (
        <InfoInput homeDirectory={homeDirectory} />
      )}
      <Text isCommand={isCommand}>{text}</Text>
    </Container>
  );
}

export default Line;