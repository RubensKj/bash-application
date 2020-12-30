import React, { useEffect, useRef, useState } from 'react';

// Components
import InfoInput from '../../components/InfoInput';
import BashInput from '../../components/BashInput/index';
import Line, { LineInterface } from '../../components/Line';

// Service
import api from '../../services/api';

// Styles
import { Container, InputArea, Lines } from './styles';
import { Input } from '../../components/BashInput/styles';

const Bash: React.FC = () => {
  const formRef = useRef<HTMLFormElement>(null);
  const inputRef = useRef<HTMLInputElement>(null);
  const divRef = useRef<HTMLDivElement>(null);

  const [homeDirectory, setHomeDirectory] = useState<String>('/');
  const [command, setCommand] = useState<String | null>(null);
  const [lines, setLines] = useState<LineInterface[]>([]);

  useEffect(() => {
    handleClearForm();
  }, []);

  function onChangeCommand(text: String) {
    setCommand(text);
  }

  function handleSubmit(event) {
    event.preventDefault();

    if (!command || !command.trim()) {
      console.error('Please write some command..');
      return;
    }

    if (command.includes('cd ')) {
      setHomeDirectory(command.trim().replace('cd', ''));
      handleClearForm();
      return;
    }

    // Should validate if it is windows or linux
    if (command === 'cls' || command === 'clear') {
      setLines([]);
      handleClearForm();
      return;
    }

    let data = {
      homeDirectory: homeDirectory,
      command: command,
    }

    api.post<LineInterface[]>('/bash/system', data).then(response => {
      setLines([...lines, { id: 'COMMAND_OLD', homeDirectory, isCommand: true, text: command }, ...response.data]);

      handleClearForm();
    }).catch(err => {
      console.error('Error during the send of command');
      console.error(err);

      alert(err);

      handleClearForm();
    });

  }

  // Create a fuction that set the form focus but not go to the divRef
  function handleClearForm() {
    formRef.current?.reset();
    formRef.current?.focus();
    divRef.current?.scrollIntoView({ behavior: 'smooth' });
  }

  function getFocus() {
    inputRef.current?.focus();
  }

  return (
    <Container onClick={getFocus}>
      <Lines>
        {lines && lines.map(line => (
          <Line id={line.id} homeDirectory={homeDirectory} isCommand={line.isCommand} text={line.text} />
        ))}
      </Lines>
      <InputArea>
        <InfoInput homeDirectory={homeDirectory} />
        <form ref={formRef} onSubmit={handleSubmit}>
          <BashInput>
            <Input name="command" ref={inputRef} onChange={e => setCommand(e.target.value)} autoComplete="false" autoCapitalize="false" />
          </BashInput>
          <div ref={divRef} />
        </form>
      </InputArea>
    </Container>
  );
}

export default Bash;