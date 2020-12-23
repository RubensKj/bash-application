import React from 'react';

import { Container } from './styles';

const BashInput: React.FC = ({ children }) => {
  return (
    <Container>
      {children}
    </Container>
  );
}

export default BashInput;