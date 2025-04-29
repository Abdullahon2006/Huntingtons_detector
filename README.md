# Huntington's Disease Genetic Analyzer

## What This Program Does

This Java program analyzes DNA sequences to detect Huntington's disease risk by counting CAG trinucleotide repeats in the HTT gene (chromosome 4). It provides medical diagnoses based on established clinical thresholds.

## Key Features

- **DNA Analysis**: Counts consecutive CAG repeats in genetic sequences
- **Diagnostic Classification**: Categorizes results into 4 medical diagnoses
- **Data Cleaning**: Handles real-world DNA data with whitespace
- **Clinical Accuracy**: Implements medically-validated thresholds

## Required Libraries
```java
import java.io.File;
import edu.princeton.cs.algs4.In; // For file input handling
```

## How to Use

1. Prepare DNA sequence file (example: `dna_sample.txt`):
   ```
   TTT CAG CAG CAG TTT CAG CAG CAG CAG TTT
   ```

2. Compile and run:
   ```bash
   javac Huntingtons.java
   java Huntingtons dna_sample.txt
   ```

## Implementation Details

### Core Methods

1. **removeWhitespace()** - Cleans DNA data:
   ```java
   public static String removeWhitespace(String s) {
       return s.replaceAll("\\s+", ""); // Removes spaces, tabs, newlines
   }
   ```

2. **maxRepeats()** - Finds longest CAG sequence:
   ```java
   int max = 0, current = 0;
   for (int i = 0; i <= dna.length() - 3; i++) {
       if (dna.substring(i, i+3).equals("CAG")) {
           current++;
           i += 2; // Skip next 2 nucleotides
           max = Math.max(max, current);
       } else {
           current = 0;
       }
   }
   ```

3. **diagnose()** - Medical classification:
   ```java
   if (max < 10) return "not human";
   else if (max <= 35) return "normal";
   else if (max <= 39) return "high risk";
   else if (max <= 180) return "Huntington's";
   else return "not human";
   ```

## Example Outputs
```bash
$ java Huntingtons repeats4.txt
max repeats = 4
not human

$ java Huntingtons chromosome4-hd.txt
max repeats = 79
Huntington's
```

## Performance

- **Time Complexity**: O(n) for both DNA processing and analysis
- **Space Complexity**: O(n) for DNA storage
- Handles full chromosome sequences (>100,000 nucleotides)

## Clinical Reference Table

| CAG Repeats | Diagnosis         |
|-------------|-------------------|
| 0-9         | Not human         |
| 10-35       | Normal            |
| 36-39       | High risk         |
| 40-180      | Huntington's      |
| 181+        | Not human         |

## Applications

- Genetic counseling
- Neurological research
- Clinical diagnostics
- Bioinformatics pipelines

## Limitations

- Does not detect other HTT gene mutations
- Requires clean DNA sequence input
- Cannot predict disease onset age

*Note: This tool is for educational purposes only. Clinical genetic testing should be performed by certified medical professionals.*
