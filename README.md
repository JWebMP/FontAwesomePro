# JWebMP Font Awesome Pro

[![Maven Central](https://img.shields.io/maven-central/v/com.jwebmp.plugins/font-awesome-pro)](https://central.sonatype.com/artifact/com.jwebmp.plugins/font-awesome-pro)
[![License](https://img.shields.io/badge/License-Apache%202.0-blue)](https://www.apache.org/licenses/LICENSE-2.0)

![Java 25+](https://img.shields.io/badge/Java-25%2B-green)
![Modular](https://img.shields.io/badge/Modular-JPMS-green)
![Angular](https://img.shields.io/badge/Angular-20-DD0031?logo=angular)
![TypeScript](https://img.shields.io/badge/TypeScript-5-3178C6?logo=typescript)

<!-- Tech icons row -->
![Font Awesome Pro](https://img.shields.io/badge/Font%20Awesome%20Pro-6.7.2-528DD7?logo=fontawesome)
![JWebMP](https://img.shields.io/badge/JWebMP-2.0-0A7)

Font Awesome Pro icon integration for JWebMP with Angular 21. Extends the Font Awesome Free plugin with Pro-exclusive icon styles: Regular, Light, Duotone, and Thin.

Built on [Font Awesome 6 Pro](https://fontawesome.com/) · [Angular FontAwesome](https://github.com/FortAwesome/angular-fontawesome) · [JWebMP Core](https://jwebmp.com/) · JPMS module `com.jwebmp.plugins.fontawesome5pro` · Java 25+

**Version: 6.7.2** — Font Awesome Pro integration with additional icon styles and 10,000+ premium icons.

## Installation

### Prerequisites

**Font Awesome Pro License Required** — This plugin requires an active Font Awesome Pro subscription. Get your license at https://fontawesome.com/plans

### Maven Dependency

```xml
<dependency>
  <groupId>com.jwebmp.plugins</groupId>
  <artifactId>font-awesome-pro</artifactId>
  <version>2.0.0-RC2</version>
</dependency>
```

<details>
<summary>Gradle (Kotlin DSL)</summary>

```kotlin
implementation("com.jwebmp.plugins:font-awesome-pro:2.0.0-RC2")
```
</details>

### NPM Configuration

Configure NPM to access Font Awesome Pro packages:

```bash
npm config set "@fortawesome:registry" https://npm.fontawesome.com/
npm config set "//npm.fontawesome.com/:_authToken" YOUR_TOKEN_HERE
```

Get your token from: https://fontawesome.com/docs/web/setup/packages#_1-configure-access

### NPM Dependencies

The plugin automatically includes Font Awesome Pro dependencies:

```json
{
  "dependencies": {
    "@fortawesome/pro-solid-svg-icons": "^6.7.2",
    "@fortawesome/pro-regular-svg-icons": "^6.7.2",
    "@fortawesome/pro-light-svg-icons": "^6.7.2",
    "@fortawesome/pro-duotone-svg-icons": "^6.7.2",
    "@fortawesome/pro-thin-svg-icons": "^6.7.2"
  }
}
```

## Features

- **10,000+ Pro Icons** — Complete Font Awesome Pro icon library
- **Pro-Exclusive Styles** — Regular, Light, Duotone, Thin icon styles
- **Extends Free Plugin** — Builds on top of Font Awesome Free (Solid, Brand)
- **Type-Safe Java API** — Compile-time safety with Java enums for icons and styles
- **SVG or Web Font** — Choose between SVG rendering or classic CSS web fonts
- **Icon Transformations** — Rotate, flip, scale, position with fluent API
- **Layering & Masking** — Combine multiple icons with layers and masks
- **Animation Effects** — Built-in spin, pulse, and custom animations
- **Sizing Options** — Preset sizes from xs to 10x, or custom sizing
- **Angular Integration** — Auto-loaded via Angular FontAwesome module
- **CRTP Fluent API** — Method chaining for icon configuration
- **Zero Configuration** — Auto-registered via ServiceLoader SPI

## Quick Start

### Prerequisites

- **Java 25 LTS** (required)
- **Maven 3.8+**
- **Node.js 18+** (for frontend builds)
- **Angular 21+** (auto-integrated via JWebMP)
- **Font Awesome Pro License** (required)
- **Font Awesome Pro Token** (NPM authentication)

### Basic Usage

```java
import com.jwebmp.plugins.fontawesome5.FontAwesome;
import com.jwebmp.plugins.fontawesome5.icons.FontAwesomeIcons;
import com.jwebmp.plugins.fontawesome5.options.FontAwesomeStyles;

// Use Pro-exclusive Regular style
FontAwesome regularIcon = new FontAwesome(FontAwesomeStyles.Regular, FontAwesomeIcons.cog);

// Use Pro-exclusive Light style
FontAwesome lightIcon = new FontAwesome(FontAwesomeStyles.Light, FontAwesomeIcons.user);

// Use Pro-exclusive Duotone style
FontAwesome duotoneIcon = new FontAwesome(FontAwesomeStyles.Duotone, FontAwesomeIcons.heart);

// Use Pro-exclusive Thin style
FontAwesome thinIcon = new FontAwesome(FontAwesomeStyles.Thin, FontAwesomeIcons.star);
```

### Pro Icon Styles in Action

```java
import com.jwebmp.plugins.fontawesome5.IFontAwesome;

// Regular - outlined style
FontAwesome regular = IFontAwesome.createIcon(FontAwesomeIcons.calendar, FontAwesomeStyles.Regular);

// Light - thin outlined style
FontAwesome light = IFontAwesome.createIcon(FontAwesomeIcons.envelope, FontAwesomeStyles.Light);

// Duotone - two-tone style with primary/secondary colors
FontAwesome duotone = IFontAwesome.createIcon(FontAwesomeIcons.database, FontAwesomeStyles.Duotone);

// Thin - very thin outlined style
FontAwesome thin = IFontAwesome.createIcon(FontAwesomeIcons.bell, FontAwesomeStyles.Thin);

// Sharp Solid - sharp-edged filled icons (Pro)
FontAwesome sharp = IFontAwesome.createIcon(FontAwesomeIcons.shield, FontAwesomeStyles.SharpSolid);
```

### Configure Pro License Key

```java
import com.jwebmp.plugins.fontawesome5pro.FontAwesome5ProPageConfigurator;

// Set Pro license key at application startup
FontAwesome5ProPageConfigurator.setProKey("YOUR_PRO_LICENSE_KEY");
```

---

## Architecture

### Technology Stack

- **Backend**: Java 25 LTS, Maven, GuicedEE (IoC)
- **Frontend**: Angular 21, TypeScript, Font Awesome 6.7.2 Pro
- **Integration**: JWebMP Page Configurators, ServiceLoader SPI
- **Rendering**: SVG via angular-fontawesome or CSS Web Fonts
- **Module System**: JPMS with explicit dependencies

### Module Structure

```
src/main/java/com/jwebmp/plugins/fontawesome5pro/
└── FontAwesome5ProPageConfigurator.java  # Pro-specific configuration
```

### Font Awesome Pro Icon Styles

| Style | Description | Availability | Java Enum |
|-------|-------------|--------------|-----------|
| **Solid** | Filled icons | Free + Pro | `FontAwesomeStyles.Solid` |
| **Regular** | Outlined icons | **Pro Only** | `FontAwesomeStyles.Regular` |
| **Light** | Thin outlined icons | **Pro Only** | `FontAwesomeStyles.Light` |
| **Duotone** | Two-tone icons | **Pro Only** | `FontAwesomeStyles.Duotone` |
| **Thin** | Very thin outlined icons | **Pro Only** | `FontAwesomeStyles.Thin` |
| **Sharp Solid** | Sharp-edged filled icons | **Pro Only** | `FontAwesomeStyles.SharpSolid` |
| **Brand** | Logo and brand icons | Free + Pro | `FontAwesomeStyles.Brand` |

### Pro vs Free Comparison

| Feature | Free | Pro |
|---------|------|-----|
| **Icons** | 2,000+ | 10,000+ |
| **Solid Style** | ✅ | ✅ |
| **Brand Style** | ✅ | ✅ |
| **Regular Style** | ❌ | ✅ |
| **Light Style** | ❌ | ✅ |
| **Duotone Style** | ❌ | ✅ |
| **Thin Style** | ❌ | ✅ |
| **Sharp Style** | ❌ | ✅ |
| **License** | Free (CC BY 4.0) | Paid subscription |

---

## API Reference

### FontAwesome5ProPageConfigurator

Pro-specific configuration class:

```java
public class FontAwesome5ProPageConfigurator {
    // Set Font Awesome Pro license key
    static void setProKey(String proKey)

    // Get Font Awesome Pro license key
    static String getProKey()
}
```

### Usage with Font Awesome Base API

The Pro plugin extends the Font Awesome Free plugin, so you use the same API:

```java
// All FontAwesome methods work with Pro styles
FontAwesome icon = new FontAwesome(FontAwesomeStyles.Light, FontAwesomeIcons.user);

icon.spin()
    .setSize(FontAwesomeSizes.$2x)
    .transform(FontAwesomeTransforms.Rotate_90);
```

---

## Configuration

### Auto-Configuration via PageConfigurator

The plugin is automatically configured when present on the classpath:

```java
@TsDependency(value = "@fortawesome/pro-solid-svg-icons", version = "^6.7.2")
@TsDependency(value = "@fortawesome/pro-regular-svg-icons", version = "^6.7.2")
@TsDependency(value = "@fortawesome/pro-light-svg-icons", version = "^6.7.2")
@TsDependency(value = "@fortawesome/pro-duotone-svg-icons", version = "^6.7.2")
@TsDependency(value = "@fortawesome/pro-thin-svg-icons", version = "^6.7.2")
public class FontAwesome5ProPageConfigurator implements IPageConfigurator {
    // Auto-loaded via ServiceLoader SPI
    // Registers Pro icon styles with Font Awesome base plugin
}
```

### Pro License Key Configuration

Set your Pro license key at application startup:

```java
import com.jwebmp.plugins.fontawesome5pro.FontAwesome5ProPageConfigurator;

public class AppConfig {
    static {
        // Option 1: Set directly
        FontAwesome5ProPageConfigurator.setProKey("YOUR_PRO_LICENSE_KEY");

        // Option 2: Load from environment variable
        String proKey = System.getenv("FA_PRO_LICENSE_KEY");
        if (proKey != null) {
            FontAwesome5ProPageConfigurator.setProKey(proKey);
        }

        // Option 3: Load from configuration file
        String proKey = ConfigLoader.getProperty("fontawesome.pro.key");
        FontAwesome5ProPageConfigurator.setProKey(proKey);
    }
}
```

---

## Testing

### Run Unit Tests

```bash
mvn clean test
```

### Code Coverage Report

```bash
mvn clean test jacoco:report
# Open: target/site/jacoco/index.html
```

### Test Example

```java
import com.jwebmp.plugins.fontawesome5.FontAwesome;
import com.jwebmp.plugins.fontawesome5.icons.FontAwesomeIcons;
import com.jwebmp.plugins.fontawesome5.options.FontAwesomeStyles;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class FontAwesomeProTest {

    @Test
    public void testProIconCreation() {
        FontAwesome icon = new FontAwesome(FontAwesomeStyles.Light, FontAwesomeIcons.user);
        assertNotNull(icon);
        assertEquals("fa-icon", icon.getTag());
    }

    @Test
    public void testDuotoneStyle() {
        FontAwesome icon = new FontAwesome(FontAwesomeStyles.Duotone, FontAwesomeIcons.heart);
        assertNotNull(icon);
    }
}
```

---

## Module Graph

```
com.jwebmp.plugins.fontawesome5pro
 ├── com.jwebmp.plugins.fontawesome5  (Font Awesome Free base)
 ├── com.jwebmp.plugins.typescript.client (TypeScript generation)
 └── jakarta.validation               (Bean validation)
```

### Exported Packages

- `com.jwebmp.plugins.fontawesome5pro` — Pro-specific configuration

> **Note**: Icon components and options are inherited from `com.jwebmp.plugins.fontawesome5`

---

## Documentation

### Core Resources

- **[Font Awesome Pro Docs](https://fontawesome.com/docs)** — Official Font Awesome Pro documentation
- **[Pro Icon Gallery](https://fontawesome.com/icons)** — Browse 10,000+ Pro icons
- **[Pro Plans](https://fontawesome.com/plans)** — Font Awesome Pro pricing
- **[Angular Font Awesome](https://github.com/FortAwesome/angular-fontawesome)** — Angular component library
- **[JWebMP Home](https://jwebmp.com/)** — JWebMP framework documentation

### Project Files

| File | Purpose |
|------|---------|
| `FontAwesome5ProPageConfigurator.java` | Pro plugin configuration |
| `pom.xml` | Maven build configuration |
| `module-info.java` | JPMS module descriptor |

---

## Common Use Cases

### Pro Style Comparison Dashboard

```java
public class StyleShowcase extends Div<StyleShowcase> {
    public StyleShowcase() {
        super();

        // Same icon in different Pro styles
        add(new FontAwesome(FontAwesomeStyles.Solid, FontAwesomeIcons.star));
        add(new FontAwesome(FontAwesomeStyles.Regular, FontAwesomeIcons.star));
        add(new FontAwesome(FontAwesomeStyles.Light, FontAwesomeIcons.star));
        add(new FontAwesome(FontAwesomeStyles.Duotone, FontAwesomeIcons.star));
        add(new FontAwesome(FontAwesomeStyles.Thin, FontAwesomeIcons.star));
    }
}
```

### Duotone Icon with Custom Colors

```java
public class DuotoneExample extends Div<DuotoneExample> {
    public DuotoneExample() {
        super();

        FontAwesome duotone = new FontAwesome(FontAwesomeStyles.Duotone, FontAwesomeIcons.layer_group);
        duotone.setSize(FontAwesomeSizes.$3x);

        // Duotone icons have primary and secondary colors
        duotone.addStyle("--fa-primary-color: #4285F4;");
        duotone.addStyle("--fa-secondary-color: #34A853;");
        duotone.addStyle("--fa-secondary-opacity: 0.6;");

        add(duotone);
    }
}
```

### Light Icon Navigation

```java
public class LightNavigation extends Div<LightNavigation> {
    public LightNavigation() {
        super();

        // Use Light style for elegant UI
        add(IFontAwesome.createIcon(FontAwesomeIcons.house, FontAwesomeStyles.Light));
        add(IFontAwesome.createIcon(FontAwesomeIcons.magnifying_glass, FontAwesomeStyles.Light));
        add(IFontAwesome.createIcon(FontAwesomeIcons.bell, FontAwesomeStyles.Light));
        add(IFontAwesome.createIcon(FontAwesomeIcons.user, FontAwesomeStyles.Light));
    }
}
```

### Thin Icon Toolbar

```java
public class ThinToolbar extends Div<ThinToolbar> {
    public ThinToolbar() {
        super();

        // Use Thin style for minimal UI
        add(IFontAwesome.createIcon(FontAwesomeIcons.floppy_disk, FontAwesomeStyles.Thin));
        add(IFontAwesome.createIcon(FontAwesomeIcons.print, FontAwesomeStyles.Thin));
        add(IFontAwesome.createIcon(FontAwesomeIcons.share_nodes, FontAwesomeStyles.Thin));
        add(IFontAwesome.createIcon(FontAwesomeIcons.trash, FontAwesomeStyles.Thin));
    }
}
```

---

## Security

This project takes security seriously.

**Key Security Features**:
- No external network calls (icons loaded from NPM packages)
- Pro license key stored securely (not in source code)
- SVG sanitization via angular-fontawesome
- OWASP Dependency-Check in CI/CD
- GitHub Dependabot enabled
- JSpecify null-safety annotations

**Pro Token Security Best Practices**:
- Store NPM token in `.npmrc` file (do not commit to version control)
- Add `.npmrc` to `.gitignore`
- Use environment variables for CI/CD token management
- Store Pro license key in secure configuration (not hardcoded)
- Use system properties or environment variables for production deployments

---

## Contributing

Contributions are welcome! Please follow these guidelines:

1. **Fork** the repository
2. **Create a feature branch** (`git checkout -b feature/my-feature`)
3. **Commit with clear messages** (`git commit -m "feat: add new Pro icon support"`)
4. **Push to your fork** (`git push origin feature/my-feature`)
5. **Open a Pull Request**

### Code Standards

- **Java**: Follow JWebMP conventions (enum naming, proper null safety)
- **Tests**: JUnit 5, ≥80% coverage (Jacoco enforced)
- **Formatting**: Maven Spotless plugin enforced
- **Documentation**: Update README for new features

---

## Project Status

| Aspect | Status |
|--------|--------|
| **Version** | 6.7.2 / 2.0.0-RC2 |
| **Icons** | 10,000+ Pro |
| **Java** | 25 LTS (required) |
| **Build** | Passing |
| **License** | Apache 2.0 |
| **Maintenance** | Active |

---

## Links

- **GitHub Repository**: https://github.com/JWebMP/JWebMP
- **Maven Central**: https://mvnrepository.com/artifact/com.jwebmp.plugins/font-awesome-pro
- **Font Awesome Pro**: https://fontawesome.com/
- **Pro Icon Gallery**: https://fontawesome.com/icons
- **Pro Plans**: https://fontawesome.com/plans
- **Angular Font Awesome**: https://github.com/FortAwesome/angular-fontawesome
- **JWebMP Home**: https://jwebmp.com/

---

## License

Licensed under the [Apache License 2.0](LICENSE).

```
Copyright 2025 JWebMP Contributors

Licensed under the Apache License, Version 2.0 (the "License");
you may not use this file except in compliance with the License.
You may obtain a copy of the License at

    http://www.apache.org/licenses/LICENSE-2.0

Unless required by applicable law or agreed to in writing, software
distributed under the License is distributed on an "AS IS" BASIS,
WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
See the License for the specific language governing permissions and
limitations under the License.
```

---

## Acknowledgments

- **[Font Awesome Pro](https://fontawesome.com/)** — Premium icon library with 10,000+ icons
- **[Angular Font Awesome](https://github.com/FortAwesome/angular-fontawesome)** — Official Angular component
- **[JWebMP](https://jwebmp.com/)** — Server-driven web framework
- **[Angular](https://angular.dev/)** — Modern web framework

---

## Support

### For JWebMP-Specific Issues

- **GitHub Issues**: https://github.com/JWebMP/JWebMP/issues
- **Discussions**: https://github.com/JWebMP/JWebMP/discussions

### For Font Awesome Pro Questions

- **Font Awesome Pro Docs**: https://fontawesome.com/docs
- **Font Awesome Support**: https://fontawesome.com/support
- **Pro Icon Search**: https://fontawesome.com/icons
- **License Questions**: https://fontawesome.com/license

---

**Made with JWebMP**
