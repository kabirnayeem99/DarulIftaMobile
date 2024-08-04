#!/bin/bash
#!/bin/bash

for file in *; do
  new_name=$(echo "$file" | tr '[:upper:]' '[:lower:]')
  mv "$file" "$new_name"
done

