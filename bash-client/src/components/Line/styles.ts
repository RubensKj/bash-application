import styled from 'styled-components';

interface StyleProps {
  isCommand: Boolean;
}

export const Container = styled.div`
  display: flex;
  justify-content: flex-start;
`;

export const Text = styled.span<StyleProps>`
  width: 100%;
  height: 100%;

  white-space: break-spaces;

  ${props => props != null && props.isCommand && (
    'margin-left: var(--space-between-info);'
  )}

  color: var(--color-text-bash) !important;
  font-size: var(--font-size-bash) !important;
`;