import React from 'react';

import { Container } from './styles';

interface Info {
  homeDirectory: String;
}

const InfoInput: React.FC<Info> = ({ homeDirectory }) => {
  return (
    <Container>
      <span>root</span>
      <span>@</span>
      <span>localhost</span>
      <span>:</span>
      <span>{homeDirectory}</span>
      <span>#</span>
    </Container>
  );
}

export default InfoInput;